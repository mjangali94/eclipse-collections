import xml.etree.ElementTree as ET
import csv
import sys

def extract_data(xml_file, csv_file):
    """
    Extracts data from a JaCoCo XML coverage report and writes it to a CSV file.

    Args:
        xml_file (str): Path to the input JaCoCo XML coverage report.
        csv_file (str): Path to the output CSV file where extracted data will be saved.
    """
    # Parse the XML file
    tree = ET.parse(xml_file)
    root = tree.getroot()

    # Open the CSV file for writing
    with open(csv_file, 'w', newline='') as csvfile:
        writer = csv.writer(csvfile)

        # Write the CSV header
        writer.writerow(['Package Name', 'Class Name', 'Covered Lines'])

        # Iterate over <package> elements in the XML
        for package in root.findall('.//package'):
            package_name = package.get('name')  # Extract the package name

            # Iterate over <sourcefile> elements in the package
            for sourcefile in package.findall('sourcefile'):
                class_name = sourcefile.get('name')  # Extract the source file (class) name
                covered_lines = []

                # Iterate over <line> elements with non-zero coverage (ci != "0")
                for line in sourcefile.findall('line[@ci!="0"]'):
                    covered_lines.append(line.get('nr'))  # Get the line number with coverage

                # Write data to the CSV only if there are covered lines
                if covered_lines:
                    writer.writerow([package_name, class_name, ';'.join(covered_lines)])

if __name__ == "__main__":
    # Ensure the script is called with the correct number of arguments
    if len(sys.argv) != 3:
        print("Usage: python script.py <input_jacoco_xml_report> <output_extracted_data.csv>")
        sys.exit(1)

    # Get the input XML file path and output CSV file path from command-line arguments
    input_xml = sys.argv[1]
    output_csv = sys.argv[2]

    # Extract data and write to CSV
    extract_data(input_xml, output_csv)
