1. Compulsory (1p)
   
Write a Java application that implements the following operations:
Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
Compute the result obtained after performing the following calculations:
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

2. Homework (2p)

A number is k-reductible if it can be reduced to the value k by adding each of its digits, multiplied by itself, repeatedly. For example 13 is 1-reductible since 1*1 + 3*3 = 10 and 1*1 + 0*0=1.
Write a program that finds all k-reductible numbers in a given interval [a,b]. The values a,b,k are given as command line argumens. Validate them.
Create a String that contains the identified numbers and display it on the screen.
Display the running time of the application in nanoseconds or milliseconds.
Launch the application from the command line, for example: java Lab1 100 200 1.
