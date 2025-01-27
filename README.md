## Logic-Loop
---
This app tests your logic skills by generating logic puzzles using natural language processing.

This project generates questions based on the propositional calculus of discrete mathematics. The goal is to use this API is to test your skills at logic.
The api itself is more focused on making the questions as accurate and effective as possible. 
The program will have a system validate generated responses for correctness.

For instance, a question like...

$$
s \implies q
$$
$$
\text{fill in the blank} 
$$
$$
\therefore\ q
$$

you would answer $s$

Obviously, this is a very basic sample, but they would get more and more complex with development.
The end goal is to have an AI generate complex logical equivalances that you would deduce through inference rules.

The end goal:

generate random questions similar to the following from my textbook:

![image](https://github.com/user-attachments/assets/9a9f699e-1ad9-43cd-b61e-57e46872ed0b)
![image](https://github.com/user-attachments/assets/83ca4fa6-17ab-4643-af71-25e2ade18f61)

I believe that if we can make an API that uses an LLM and structured generation, we could replicit these sorts of questions.
I want to do this because I think getting good at logic and deducing the validity of arguments is a fun and rewarding experience!
