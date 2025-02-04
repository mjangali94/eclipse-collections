# Read test list
with open("test_list.txt", "r") as file:
    test_methods = file.readlines()

# Extract distinct class names (before the last '.')
test_classes = sorted(set(".".join(line.strip().split(".")[:-1]) for line in test_methods))

# Save to a new file
with open("distinct_test_classes.txt", "w") as output:
    output.write("\n".join(test_classes))

print("Distinct test classes saved to distinct_test_classes.txt")
