# CSV_FILE_COMPARATOR

**CSV_FILE_COMPARATOR** is a Java project that allows you to:

- Read CSV files.
- Modify CSV data (e.g., remove rows with odd indices).
- Compare two CSV files row by row and column by column.
- Identify differences and generate a report of mismatched rows and cells.
- Save the differences into a `differences.txt` file.

---

## Features

1. **Open CSV files** using `OpenFile.java`.
2. **Modify CSV rows** using `ChangeFile.java`.
3. **Compare CSV files** using `CompareFiles.java`.
4. **Detailed reporting**:
    - Differences by row and column.
    - Cells that exist only in one file.
    - Export differences to `differences.txt`.

---

## Getting Started

### Prerequisites

- Java JDK 11+  
- Gradle 6+  
- OpenCSV library (`lib/opencsv-5.9.jar`)

### Running the project

1. Clone the repository:
   ```bash
   git clone https://github.com/Sandukht/CSV_FILE_COMPARATOR.git
   cd CSV_FILE_COMPARATOR
   
## Build and run using Gradle:

./gradlew run

## After running:

output.csv will contain the modified CSV data.

differences.txt will list all differences between input.csv and output.csv.

## Project Structure

CSV_FILE_COMPARATOR/
│
├─ src/main/java/com/example/
│  ├─ OpenFile.java        # Reads CSV files
│  ├─ ChangeFile.java      # Modifies CSV data
│  ├─ CompareFiles.java    # Compares CSV files and generates differences
│  └─ Main.java            # Runs the project
│
├─ lib/
│  └─ opencsv-5.9.jar      # OpenCSV dependency
│
├─ input.csv               # Example input file
├─ output.csv              # Generated output file
└─ differences.txt         # Generated differences report

## Example Output

✅ input.csv is read (100 lines).

✅ output.csv is created (50 lines).

✅ output.csv is read (50 lines).

🔍 File Comparison...

===== FINAL REPORT =====
The CSV files have differences:
✅ Changes written to differences.txt
