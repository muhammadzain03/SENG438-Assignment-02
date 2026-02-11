## **SENG 438 - Software Testing, Reliability, and Quality**

## **Lab Report #2 – Requirements-Based Test Generation**

| Group #: | 08 |
|--------|----|
| Student Name 01 | Muhammad Zain |
| Student Name 02 | Fateh Ali Syed Bukhari |
| Student Name 03 | Yazin Abdul Majid |

---

# 1 Introduction

This lab focuses on requirements-based (black-box) testing using API specifications. The objective is to design and implement unit tests for selected classes from the JFreeChart library without referring to their internal implementations. By relying strictly on Javadoc specifications, this assignment reinforces systematic test-case design techniques such as equivalence class partitioning and boundary value analysis.

---

# 2 Detailed description of unit test strategy

### 2.2.3 Test Plan and Test-case Design

#### Test Plan

The objective of this test plan is to verify the correctness and robustness of methods in `org.jfree.data.DataUtilities` and selected methods in `org.jfree.data.Range` based strictly on their documented requirements. Since only API specifications are provided, all tests follow a **black-box, requirements-based testing approach**.

The scope of testing includes:
- All **5 public methods** of `org.jfree.data.DataUtilities`
- **5 selected methods** out of the 15 available in `org.jfree.data.Range`

JUnit 5 is used as the testing framework to implement and execute all unit tests. The focus is on validating normal behavior, boundary conditions, and handling of invalid inputs where specified.

---

#### Test-case Design Approach

Test cases are designed using black-box test-case design techniques discussed in class, primarily:

- **Equivalence Class Partitioning (ECP)**
- **Boundary Value Analysis (BVA)**

For each method under test, the following systematic process is followed:

1. Identify all input variables from the method signature.
2. Determine the valid and invalid input domains using the Javadoc specification.
3. Partition each input domain into equivalence classes.
4. Identify boundary values for numeric inputs or index-based parameters.
5. Design test cases that cover all identified equivalence classes and boundary values.
6. Ensure that all stated requirements are adequately tested.

All test cases are first documented in this report before being implemented in JUnit to ensure traceability and correctness.

---

#### Example Application of Test-case Design

For methods in `Range` that operate on numerical intervals (e.g., `contains()`, `getCentralValue()`), equivalence classes include:
- Values strictly inside the range
- Values equal to the lower bound
- Values equal to the upper bound
- Values outside the range

Boundary value analysis is applied by testing values at, just below, and just above the range boundaries.

For array-based methods in `DataUtilities`, equivalence classes include:
- Valid non-null arrays with valid numeric data
- Arrays containing null elements
- Empty arrays
- Null array references

This approach ensures that both normal and edge-case behaviors defined in the API specifications are thoroughly tested.

---

# 3 Test cases developed

Text…

// Write down the name of the test classes and test methods.  
// Organize them based on the source code method they test.  
// Clearly identify which test cases cover which equivalence  
// classes and boundary conditions described in Section 2.

---

# 4 How the team work/effort was divided and managed

Text…

---

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

---

# 6 Comments/feedback on the lab itself

Text…
