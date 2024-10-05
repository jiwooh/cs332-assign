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
