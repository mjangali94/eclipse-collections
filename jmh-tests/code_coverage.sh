#!/bin/bash

JMH_JAR_FILE="microbenchmarks.jar"
BENCHMARK_LIST="benchmark_list.txt"
OUTPUT_DIR="individual_coverage_reports"
JACOCO_AGENT_JAR="org.jacoco.agent.jar"
JACOCO_CLI_JAR="org.jacoco.cli.jar"
CLASS_FILES_MAIN="/Users/mj/workspace/eclipse-collections/eclipse-collections/target/classes/"
CLASS_FILES_JMH="target/classes/"
PYTHON_SCRIPT="xml_to_csv.py"

mkdir -p "$OUTPUT_DIR"

# JMH Config: Disable forking and minimize warmup
JMH_CONFIG="-f 1 -wi 0 -i 1 -r 1 -w 1 -bm ss -foe true"

while IFS= read -r benchmark || [[ -n "$benchmark" ]]; do
    [[ -z "$benchmark" || "$benchmark" =~ ^# ]] && continue

    echo "Processing benchmark: $benchmark"
    benchmark_dir="$OUTPUT_DIR/$benchmark"
    mkdir -p "$benchmark_dir"

    # **Ensure JaCoCo Captures Both JMH and Main Code**
    java -javaagent:"$JACOCO_AGENT_JAR"=output=file,destfile="$benchmark_dir/coverage.exec",includes=org.eclipse.collections.* \
         -jar "$JMH_JAR_FILE" "$benchmark\$" $JMH_CONFIG

    [[ ! -f "$benchmark_dir/coverage.exec" ]] && echo "Error: Coverage file not generated for $benchmark" && continue

    # **Generate XML Report**
    java -jar "$JACOCO_CLI_JAR" report "$benchmark_dir/coverage.exec" \
         --classfiles "$CLASS_FILES_MAIN" \
         --classfiles "$CLASS_FILES_JMH" \
         --xml "$benchmark_dir/report.xml"

    # **Convert XML to CSV (Optional)**
    [[ -f "$PYTHON_SCRIPT" ]] && python "$PYTHON_SCRIPT" "$benchmark_dir/report.xml" "$benchmark_dir/report.csv"

    # **Cleanup**
    rm -f "$benchmark_dir/report.xml" "$benchmark_dir/coverage.exec"

done < "$BENCHMARK_LIST"
