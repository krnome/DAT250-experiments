# DAT250
## Experiment Assignment 2 - Report

---

### Installation: Derby Database

I completed the Derby tutorial that was [linked in the assignment](http://db.apache.org/derby/papers/DerbyTut/index.html), without any issues. I created a table, inserted rows and update a row.

---

### Experiment 1: Application using JPA

I chose not to use the given Maven project, but followed [the Vogella tutorial](https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html#installation). I encountered some confusion when trying to add Derby and Eclipselink to the project's build path, and ended up downgrading my project's JRE to Java 1.8, which was more familiar to me.

The tutorial included creating a small Todo-entity which can be found in the included code, in the package [no.hvl.dat250.exp2.todo](https://github.com/krnome/DAT250-experiments/tree/master/exp2/src/no/hvl/dat250/exp2/todo).
Part of the experiment included inspecting the database tables - I chose to do this by logging into the database server from the command line.
[!Todos in the database](img/DBSelect.png)

The next steps included creating several entities with relations: Family, Person and Job. These classes can be found in the included code, in the package [no.hv.dat250.exp2.model](https://github.com/krnome/DAT250-experiments/tree/master/exp2/src/no/hvl/dat250/exp2/model).
Again, I inspected these tables by logging into the database server from the command line.
[!Model tables in the database](img/modelTables.png)

[!Table for the family-entity](img/modelFamily.png)

