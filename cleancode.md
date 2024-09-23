# Clean Code
## Chapter 2: Meaningful Names
### 1. Use Intention-Revealing Names
- bad: ```int d; // elapsed time in days```
- good: ```int elapsedTimeInDays;```
  
### 2. Avoid Disinformation
- avoid leaving false clues the obscure the meaning of code
- better not to encode the container type into the name
- bad: ```accountsList```
- good: ```accounts```

### 3. Make Meaningful Distinctions
- if names must be different, then they should also mean something different
- noise words are meaningless distinctions (```a```, ```the```, ```data```, ```info```, ```variable```, ```table```, ...)
- bad: ```ProductInfo```, ```ProductData```
- good: ```Product```

### 4. Use Pronounceable Names
- this matters because programming is a social activity
- bad: ```private Date genymdhms;```
- good: ```private Date generationTimestamp;```

### 5. Use Searchable Names
- single-letter names and numeric constants have a particular problem in that they are not easy to locate across a body of text
- bad:
```
for (int j = 0; j < 34; j++) {
    s += (t[j] * 4) / 5;
}
```
- good:
```
int realDaysPerIdealDay = 4;
const int WORK_DAYS_PER_WEEK = 5;
int sum = 0;
for (int j=0; j < NUMBER_OF_TASKS; j++) {
    int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
    int realTaskWeeks = (realdays / WORK_DAYS_PER_WEEK);
    sum += realTaskWeeks;
}
```

### 6. Avoid Encodings
- encoding type or scope information into names simply adds an extra burden of deciphering

### 7. Avoid Mental Mapping
- readers shouldn't have to mentally translate your names into other names they already know
- in most contexts a single-letter name is a poor choice

### 8. Class Names
- classes and objects should have noun or noun phrase names like ```Customer```, ```WikiPage```, ```Account```, and ```AddressParser```
- avoid words like ```Manager```, ```Processor```, ```Data```, or ```Info``` in the name of a class

### 9. Method Names
- methods should have verb or verb phrase names like ```postPayment```, ```deletePage```, or ```save```

### 10. Don't Be Cute
- say what you mean. Mean what you say.
- no humour, inside jokes, or puns

### 11. Pick One Word per Concept
- pick one word for one abstract concept and stick with it
- it's confusing to have ```fetch```, ```retrieve```, and ```get``` as equivalent methods of different classes

### 12. Don't Pun
- avoid using the same word for two purposes

### 13. Use Solution Domain Names
- use computer science terms, algorithm names, pattern names, math terms, etc.

### 14. Use Problem Domain Names
- use names from the problem domain

### 15. Add Meaningful Context
- you need to place names in context for your reader by enclosing them in well-named classes, functions, or namespaces
- when all else fails, then prefixing the name may be necessary as a last resort

### 16. Don't Add Gratuitous Context
- short names are generally better than long ones, as long as they are clear


## Chapter 3: Functions
### 1. Small!
- the first rule of functions is that they should be small
- the second rule of functions is that they \*should be smaller than that*
- implies that the blocks within if statements, else statements, while statements, and so on should be one line long

### 2. Do One Thing
- "Functions should do one thing. They should do it well. They should do it only."
- if a function does only those steps that are one level of abstraction below the stated name of the function, then the function is doing one thing

### 3. One Level of Abstraction per Function
- reading code from top to bottom: the code should read like a top-down narrative
- we want to be able to read the program as though it were a set of TO paragraphs, each of which is describing the current level of abstraction and referencing subsequent TO paragraphs at the next level down

### 4. Switch Statements
- can be tolerated if they appear only once, are used to create polymorphic objects, and are hidden behind an inheritance relationship so that the rest of the system can't see them

### 5. Use Descriptive Names
- don't be afraid to make a name long
- a long descriptive name is better than a short enigmatic name
- don't be afraid to spend time choosing a name

### 6. Function Arguments
- the ideal number of arguments for a function is zero (niladic)
- the argument is at a different level of abstraction than the function name and forces you to know about how the argument is implemented

### 7. Have No Side Effects
- side effects are lies
- functions should do one thing, and side effects are another thing

### 8. Command Query Separation
- functions should either do something or answer something, but not both
- either your function should change the state of an object, or it should return some information about that object

### 9. Prefer Exceptions to Returning Error Codes
- returning error codes is a low-level concern and should be handled by the caller
- use exceptions instead of returning error codes

### 10. Don't Repeat Yourself
- duplication may be the root of all evil in software

### 11. Structured Programming
- every function and every block within a function should have one entry and one exit
- this implies that there should only be one return statement in a function, no break or continue statements in a loop, and never, ever, any goto statements

## Chapter 4: Comments
### 1. Comments Do Not Make Up for Bad Code
- clear and expressive code with few comments is far superior to cluttered and complex code with lots of comments

### 2. Explain Yourself in Code
- it takes only a few seconds for your eyes to glance over the code and see the explanation

### 3. Good Comments
- include the copyright notice at the top of each source file
- provide basic information with a comment
- sometimes a comment goes beyond just useful information about the implementation and provides the intent behind a decision
- translate the meaning of some obscure arguemnt or return value into something that's readable
- warn other programmers about consequences of using a function or test
- reasonable to leave "TODO" notes
- amplify the importance of something that may otherwise seem inconsequential

### 4. Bad Comments
- if you decide to write a comment, then spend the time necessary to make sure it is the best comment you can write
- some comments are not precise enough to be accurate
- mandated, journal, noise comments are unnecessary
- don't use a comment when you can use a function or a variable
- use position markers only when the benefit is significant
- closing brace comments clutter small preferred functions
- no attributions and bylines
- avoid commenting out code
- do not offer systemwide information in the context of a local comment

## Chapter 7: Error Handling
### 1. Use Exceptions Rather Than Return Codes
- return codes clutter the caller by making them check for errors immediately after each call

### 2. Write Your Try-Catch-Finally Statement First
- helps you define what the user of that code should expect, no matter what goes wrong with the code that is executed in the try block
- try to write tests that force exceptions, and then add behavoir to your handler to satisfy your tests

### 3. Use Unchecked Exceptions

### 4. Provide Context with Exceptions
- each exception that you throw should provide enough context to determine the source and location of an error

### 5. Define Exception Classes in Terms of a Caller's Needs

### 6. Define the Normal Flow
- the client code doesn't have to deal with exceptional behavior when you create a class or configure an object so that it handles a special case

### 7. Don't Return Null & Don't Pass Null
- when we return null, we are essentially creating work for ourselves and foisting problems upon our callers
- all it takes is one missing null check to send an application spinning out of control
- returning null from methods is bad, but passing null into methods is worse
- in most programming languages there is no good way to deal with a null that is passed by a caller
