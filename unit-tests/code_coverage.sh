#!/bin/bash

# Path to the text file containing the list of test methods (Format: ClassName#methodName)
TEST_LIST="test_list.txt"

# Output directory for individual coverage reports
OUTPUT_DIR="individual_coverage_reports"

# Path to JaCoCo agent JAR
JACOCO_AGENT_JAR="org.jacoco.agent.jar"

# Path to JaCoCo CLI JAR
JACOCO_CLI_JAR="org.jacoco.cli.jar"

# Path to binary classes
CLASS_FILES="target/test-classes/"

# Python script to convert XML report to CSV
PYTHON_SCRIPT="xml_to_csv.py"

# Ensure the required files and directories exist
if [[ ! -f "$TEST_LIST" ]]; then
    echo "Error: Test list file not found at $TEST_LIST"
    exit 1
fi

if [[ ! -f "$JACOCO_AGENT_JAR" ]]; then
    echo "Error: JaCoCo agent JAR not found at $JACOCO_AGENT_JAR"
    exit 1
fi

if [[ ! -f "$JACOCO_CLI_JAR" ]]; then
    echo "Error: JaCoCo CLI JAR not found at $JACOCO_CLI_JAR"
    exit 1
fi

if [[ ! -d "$CLASS_FILES" ]]; then
    echo "Error: Binary classes directory not found at $CLASS_FILES"
    exit 1
fi

# Create output directory if it doesn't exist
mkdir -p "$OUTPUT_DIR"

# Iterate over each test in the list
while IFS= read -r test || [[ -n "$test" ]]; do
    # Skip empty lines or comments
    if [[ -z "$test" || "$test" =~ ^# ]]; then
        continue
    fi

    echo "Processing test: $test"

    # Create directory for the test
    test_dir="$OUTPUT_DIR/$test"
    mkdir -p "$test_dir"

    # Run the test with JaCoCo agent to capture coverage
    mvn clean test -Dtest="$test" -DargLine="-javaagent:$JACOCO_AGENT_JAR=destfile=$test_dir/coverage.exec"

    # Check if the coverage execution file was generated
    if [[ ! -f "$test_dir/coverage.exec" ]]; then
        echo "Error: Coverage file not generated for $test"
        continue
    fi

    # Generate code coverage report in XML format
    java -jar "$JACOCO_CLI_JAR" report "$test_dir/coverage.exec" \
         --classfiles "$CLASS_FILES" \
         --xml "$test_dir/report.xml"

    # Convert XML report to CSV using the Python script
    if [[ -f "$PYTHON_SCRIPT" ]]; then
        python "$PYTHON_SCRIPT" "$test_dir/report.xml" "$test_dir/report.csv"
        # Remove the XML report after successful conversion
        rm -f "$test_dir/report.xml"
        rm -f "$test_dir/coverage.exec"
    else
        echo "Warning: Python script $PYTHON_SCRIPT not found. Skipping XML to CSV conversion."
    fi
done < "$TEST_LIST"
