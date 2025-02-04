import os
import re

def comment_out_benchmark_classes(file_path):
    # Read the file content
    with open(file_path, 'r') as file:
        content = file.readlines()

    # Find the lines to comment out (Benchmark class)
    in_benchmark_class = False
    modified_content = []
    
    for line in content:
        # Check if the line starts a Benchmark class (public class _Benchmark or similar)
        if re.match(r'\s*public\s+static\s+class\s+_?Benchmark', line):
            in_benchmark_class = True
            modified_content.append("/*\n")  # Start comment block

        # If we're inside a Benchmark class, comment the line
        if in_benchmark_class:
            modified_content.append(f"// {line}")
        
        # Check if the line contains Benchmark annotations and comment them out
        if re.match(r'\s*@org\.openjdk\.jmh\.annotations\..*', line):
            if in_benchmark_class:
                modified_content.append(f"// {line}")
        
        # Check if the line ends a Benchmark class
        if in_benchmark_class and '}' in line:
            in_benchmark_class = False
            modified_content.append("*/\n")  # End comment block

        # Otherwise, just append the line as it is
        else:
            modified_content.append(line)

    # Write the modified content back to the file
    with open(file_path, 'w') as file:
        file.writelines(modified_content)

def comment_benchmark_classes_in_directory(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            # Only process .java files
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                comment_out_benchmark_classes(file_path)
                print(f"Processed: {file_path}")

if __name__ == '__main__':
    directory_path = input("Enter the directory path to scan: ")
    comment_benchmark_classes_in_directory(directory_path)
