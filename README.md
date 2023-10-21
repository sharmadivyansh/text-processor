## Text processor
A command-line tool for manipulating text files, such as sorting lines of text alphabetically and removing duplicate lines.

### Features
- Ability to sort lines of text alphabetically in ascending or descending order.
(Default ascending)
- Ability to remove duplicate lines from a text file.
- Ability to search for specific text within a file and return the line numbers where it appears.
- Ability to replace a specific text within a file with new text.
- Ability to merge two or more text files into a single file.

### Usage
- textprocessor sort filename [options]
  - `-a`: sort file ascendingly
  - `-d`: sort file descendingly
- textprocessor remove filename
- textprocessor search filename word
- textprocessor replace filename existing-text new-text
- textprocessor merge filename1 filename2 filename
