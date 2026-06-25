# LeetCode Java Practice

This repository is a personal Java workspace for practicing LeetCode problems locally before submitting solutions on LeetCode.

The goal is to keep each problem easy to write, run, and review from the terminal.

## Structure

```text
leetcode-java/
|-- Easy/
|-- Medium/
`-- Hard/
```

Problems are grouped by difficulty. Each Java file usually contains:

- The solution method or helper class
- A `main` method with sample test cases
- Simple console output for quick local checking

## Running A Solution

On Windows, use the included runner so Vietnamese console output is displayed as UTF-8:

```cmd
.\run.cmd Easy.Leet01_TwoSum
.\run.cmd Medium.Leet238_ProductExceptSelf
```

The script compiles all Java files with UTF-8 source encoding into `.build/classes`, then runs the class you choose.

If Vietnamese text still appears as `?`, make sure you are running through `run.cmd` instead of calling `java` directly from an old terminal session.

Manual compile:

```bash
javac -encoding UTF-8 Easy/*.java Medium/*.java Hard/*.java
```

If one difficulty folder has no `.java` files yet, compile only the folders that currently contain solutions.

## Submitting To LeetCode

Before submitting, copy only the required solution code into LeetCode's editor.

Usually this means removing local-only parts such as:

- `package Easy;` or `package Medium;`
- The `main` method
- Local test-printing helper methods

LeetCode often expects the submitted code to use:

```java
class Solution {
    // solution method here
}
```

Some design problems may require a specific class name, such as `LRUCache`.

## Notes

Generated Java bytecode files and the local build directory are ignored by Git:

```gitignore
*.class
.build/
```

This keeps the repository focused on source code only.
