# Workshop 1

This is the first workshop where the following exercise was implemented: 

Build a header checker software middleware that implements the validator pattern.
(For functional enthusiasts: Use only lambdas for checks, Beware of exception
handling in functional context).

This was done using an interface for all the header validator where each header validator knew which predicate to implement, it was all supported by getting all these validators automatically using the @Autowired spring annotation (This was possible since each validator was declared as a Spring Component)
