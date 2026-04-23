Triage Priority Simulation System
# Overview

This project simulates a hospital triage system where patients are prioritized based on a calculated score. The system is designed for a disaster scenario where medical resources are limited and not all patients can be treated immediately.

Instead of using a standard queue, the program stores patients in a sorted list and allows flexible ways to choose the order of treatment.

# How It Works

Each patient is assigned a total score based on:

Illness severity (40 points)
Profession (20 points)
Age (20 points)
Gender (20 points)

These values are added together to form a final priority score.

Patients are stored in a list sorted by:

Total score
Arrival order (used to break ties)
Features
1. Add Patients

Users can add patients to the system with their scores.

2. Sorted List

Patients are automatically placed in the correct position based on their priority score.

3. Treatment Modes

The user can choose how treatment is processed:

Directional mode:
Start at a chosen index and move left or right through the list.
Outward mode:
Start at a chosen index and alternate outward (left, then right, expanding).

# Data Structure

The main data structure is a sorted ArrayList of Patient objects.

# The system uses:

Binary search for insertion position
A pointer for tracking treatment position
A direction value for traversal

# Complexity
Adding a patient: O(n)
Finding insertion point: O(log n)
Treating a patient: O(1)
Traversing list: O(n)

# Limitations
No real-time score updates after insertion
Uses linear array shifting for inserts
Designed for simulation, not production use
Purpose

# The goal of this project is to demonstrate:

Priority-based sorting
Custom data structure design
Different traversal strategies over ranked data

# Requirements
Java Version: Java 8 or higher
Works in:
IntelliJ IDEA
Eclipse
VS Code
Terminal / command line

No external libraries are required.

# How to Compile & Run
Using Terminal
Navigate to the project folder:

cd path/to/project
Compile all files:

javac Main.java TriageSystem.java Patient.java

Run the program:
java Main

# Example Usage

When you run the program:

A list of sample patients is created and displayed
You choose:
A starting index
A treatment mode
The system prints the treatment order

