# The Mythical Man-Month
## Chapter 1: The Tar Pit
- Large-system programming has been such a tar pit, and many great and powerful beasts have thrashed violently in it
- let's identify the craft of system programming and the joys and woes inherent in it
### The Programming Systems Product
- there are two ways a program can be converted into a more useful, but more costly, object
  - becoming a programming product
    - can be run, tested, repaired, and extended by anybody
    - must be written in a generalized fashion
    - requires its thorough documentation
  - becoming a component in a programming system
    - a collection of interacting programs, coordinated in function and disciplined in format
    - must be designed to use only a prescribed budget of resources
  - becoming a programming systems product
    - the intended product of most system programming efforts
### The Joys of the Craft
- the joy of making things
- the joy of making things that are useful to other people
- the fascination of fashioning complex puzzle-like objects of interlocking moving parts
- the joy of always learning
- the delight of working in a tractable medium
### The Woes of the Craft
- one must perform perfectly
- other people set one's objectives, provide one's resources, and furnish one's information.
- finding nitty little bugs is just work
- product over which one has labored so long appears to be obsolete upon completion

## Chapter 2: The Mythical Man-Month
### Optimism
- first false assumption that underlies the scheduling of systems programming is that all will go well
- creative activity is divided into three stages: the idea, the implementation, and the interaction
- computer programming creates with an exceedingly tractable medium, so we expect few difficulties in implementation; hence our pervasive optimism
### The Man-Month
- cost does vary as the product of the number of men and months but progress does not
- man-month as a unit for measuring the size of a job is a dangerous and deceptive myth
1. Men and months are interchangeable commodities only when a task can be partitioned among many workers with no communication among them
2. If tasks cannot be partitioned due to sequential constratins, then the application of more effort has no effect on the schedule
3. tasks that can be partitioned but require communication among the subtasks require effort of communication to be added to the amount of work to be done
  - added burden of communication = training + intercommunication
### Systems Test
- scheduling a software task
  - 1/3 planning, 1/6 coding, 1/4 component test and early system test, 1/4 system test and all components in place
- failure to allow for system testing is the most common cause of late delivery
### Gutless Estimating
- need to develop and publicize productivity figures, since only strong management can resist the winds of optimism
- individual managers need to defend their estimates with the assurance that their poor estimates are better than wish-drived ones
### Regenerative Schedule Disaster
- "Adding manpower to a late software project makes it later."
- the number of months of a poject edpends upon its sequential constraints

## Chapter 3: The Surgical Team
### Mills' Proposal
- each segment of a large job be tackled by a team oraganized like a surgical team
- surgeon: the chief programmer, defines the functional and performance specifications, designs, codes, tests the program, and writes its documentation
- copilot: share in the design as a thinker, discussant, and evaulator
- administrator: handles money, people, space, and machines
- editor: criticizes and reworks the manuscript produced by the surgeon
- program clerk: maintains all the technical records of the team in a programming-product library
- toolsmith: provides the team with the tools and techniques needed to do its job
- tester: devises tests and exercises the program
- language lawyer: find a neat and efficient way to user the language
### How It Works
- the surgeon and copilot are each cognizant of all of the design and all of the code
- there are no differences of interest, and differences of judgment are settled by VVthe surgeon unilaterally

## Chapter 16: No Silver Bullet
### Essential Difficulties
- complexity
  - software is inherently complex due to unique, non-repetitive parts
  - results in communication challenges, increased costs, schedule delays, and reduced reliability
- conformity
  - software must conform to other systems and interfaces, often with arbitrary requirements, adding complexity
- changeability
  - software product is embedded in a cultural matrix of applications, users, laws, and machine vehicles
  - these all change continually, and their changes inexorably force change upon the software product
- invisibility
  - has no ready geometric representation
  - inherently unvisualizable, and thus do not permit the mind to use some of its most powerful conceptual tools
### Past Breakthroughs Solved Accidental Difficulties
- High-level languages
  - frees a program from much of its accidental complexity
  - eliminates a whole level of complexity that was never inherent in the program at all
- Time-sharing
  - brought a major improvement in the productivity of programmers and in the quality of their product
  - preserves immediacy, and hence enables one to maintain an overview of complexity
- Unified programming environments
  - attack the accidental difficulties that result from using individual programs together, by providing integrated libraries, unified file formats, and pipes and filters
### Hopes for the Silver
- Ada and other high-level language advances
  - will not prove to be the silver bullet that slays the software productivity monster
  - just another high-level language
- Object-oriented programming
  - allow one to define general interfaces that can be further refined by providing subordinate types
  - can do no more than to remove all the accidental difficulties from the expression of the design
- Artificial intelligence
  - hard thing about building software is deciding what one wants to say, not saying it
- Expert systems
  - may assist programmers by encoding expert knowledge but depend heavily on accurate, expert input for rule creation
- Automatic programming
  - hard to see it generalize to the wider world of the ordinary software system, where cases with such neat properties are the exception
- Graphical programming
  - "software is very difficult to visualize"
- Program verification
  - does not mean error-proof programs
  - even perfect program verification can only establish that a program meets its specification
- Environments and tools
  - marginal gains only
- Workstations
  - have limited impact on speedup
### Promising Approaches to Addressing Conceptual Essence
- Buy versus Build
  - any such product is cheaper to buy than to build afresh
  - off-the-shelf software reduces development costs and accelerates deployment
- Requirements refinement and rapid prototyping
  - prototyping allows iterative development and helps clarify requirements with clients, addressing the difficulty of defining precise requirements
- Great designers
  - good design practices can be taught
  - great designs come from great designers