import os
import re

def comment_out_benchmark_class(file_path):
    with open(file_path, 'r') as f:
        lines = f.readlines()

    new_lines = []
    i = 0
    while i < len(lines):
        line = lines[i]
        # Look for the @State annotation line that marks the start of a Benchmark block.
        if re.search(r'@org\.openjdk\.jmh\.annotations\.State\(org\.openjdk\.jmh\.annotations\.Scope\.Thread\)', line):
            # Remember where the block starts.
            block_start = i
            # Advance through any intervening lines until we reach the class declaration.
            while i < len(lines) and not re.search(r'\bclass\b.*_Benchmark', lines[i]):
                i += 1
            if i >= len(lines):
                # No Benchmark class found after the annotation; add the lines as-is.
                new_lines.extend(lines[block_start:])
                break

            # Now, i points to a line containing the class declaration.
            # We'll now capture from the block_start (which includes the @State annotation)
            # until the matching closing brace of the Benchmark class.
            block_lines = []
            # Include all lines from block_start up to the current line.
            for j in range(block_start, i):
                block_lines.append(lines[j])
            # Now process the Benchmark class block.
            brace_count = 0
            found_open = False
            # Process from the class declaration onward.
            while i < len(lines):
                current_line = lines[i]
                block_lines.append(current_line)
                # Look for the first opening brace.
                if not found_open and "{" in current_line:
                    found_open = True
                if found_open:
                    brace_count += current_line.count('{')
                    brace_count -= current_line.count('}')
                    if brace_count <= 0:
                        # We assume the block is closed when brace_count returns to 0.
                        i += 1  # include this line and then break out of the loop
                        break
                i += 1

            # Now wrap the captured block in block comment markers.
            new_lines.append("/*\n")
            new_lines.extend(block_lines)
            new_lines.append("*/\n")
        else:
            new_lines.append(line)
            i += 1

    with open(file_path, 'w') as f:
        f.writelines(new_lines)
    print(f"Processed: {file_path}")

def comment_benchmark_classes_in_directory(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            # Process only .java files
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                comment_out_benchmark_class(file_path)

if __name__ == '__main__':
    directory_path = input("Enter the directory path to scan: ")
    comment_benchmark_classes_in_directory(directory_path)
