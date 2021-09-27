# School Management System
## Definitions
`name`: The name of each Student / Teacher consists of exactly two Strings separated by a space.

`grade`: Of a Student Is an Integer.

`price` : Of a course is defined as an Integer.

`course_name` : Of a Course is a String.

`code` : Of a course is defined as a String.

To update any entity, you can add it again with the same name but different properties

### Student Details
To add an student detials, add the definitions in the following order

`name grade`

This will register a student.

### Course Details
To add a course, provide the definitions with the below approach.

`course_name code price name(teacher) num name_1(student) name_2(student) ... `

where `num` represents the number of student who are registered in this course.

*Note* : To add an course, all the students and the teachers must be already registered in this school.