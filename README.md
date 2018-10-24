Introduction: SQLiteBuilder ORM (Object Relational Mapping) tool
===============================================================
SQLiteBuilder library simplifies the development of Android application to interact with the database. SQLiteBuilder is an open source, lightweight, ORM (Object Relational Mapping) tool.
An ORM tool simplifies the data creation, data manipulation and data access. It is a programming technique that maps the object to the data stored in the database.

## Advantages:

* SQLiteBuilder takes care of mapping Java classes to SQLite database.
* Provides simple APIs for storing and retrieving Java objects directly to and from SQLite database
* If there is change in the database or in any table, then you need to change the java Class properties only
* Minimizes database access with smart fetching strategies.
* Provides simple querying of data.
* Automatic table creation: SQLiteBuilder Library provides the facility to create the tables of the database automatically. So there is no need to create tables in the SQLite database manually.

## Setup
The simplest way to use SQLiteBuilder is to add the library as aar dependency to your build.


**Maven**

    <dependency>
      <groupId>landepatil.vishal</groupId>
      <artifactId>sqlitebuilder</artifactId>
      <version>1.0.2-beta</version>
      <type>pom</type>
    </dependency>
	
	
**Gradle**

    repositories {
        mavenCentral()
    }

    dependencies {
        compile 'landepatil.vishal:sqlitebuilder:1.0.2-beta'
    }




## What is POJO in Java?

**POJO** means *__Plain Old Java Object__* ,which contains only private variables and corresponding getter and setter (Optional) methods is called POJO CLASS. simply it is normal java class. it does not contains business implimentations. it is specified for "object creation" and call with object.

## Example :
```
class  Student
{
	public Student(int rollno, String name)
	{
		this. rollno= rollno;
		this. name = name;
	}
	int rollno;
	String name;
	
	void setRollno(int rollno)
	{
		this. Rollno= rollno;
	}
	void setName (int name)
	{
		this. name = name;
	}
	String getName()
	{
		return name;
	}
	String getRollno ()
	{
		return rollno;
	}
}
```

## 1. Create Table :
POJO object directly represented in database by using create Table menthod,To create table in android using **SQLiteBuilder**  Library, *__createTable(Class class)__* method  of  *__TableFactory__* class  is used as follows. 

**Syntax of method:**
```
public static String createTable(Class table, SQLiteDatabase database) 
```
**Example**
```
TableFactory.createTable(ExapmleTable.class,db);
```
## 2. Drop Table :
To drop table from android using **SQLiteBuilder** Library, *__dropTable(Class class)__* method  of  *__TableFactory__* class  is used as follows. 

**Syntax of method:**
```
public static String dropTable(Class table) 
```
**Example**
```
db.execSQL(TableFactory.dropTable(ExapmleTable.class));
```

## 3. QUERY in SQLiteBuilder:
This SQLite tutorial explains how to Generate SQLite Queries using SQLiteBuilder Library, to **retrieve**,**insert**,**delete** records 
**Query class of SQLiteBuilder Library is Used to create a different types of Queries**,  to Create object of Query Class use **createQuery()** static method of  Query class is used 

**Syntax of method:**
```
public static Query createQuery(SQLiteOpenHelper db)
```
**Example**

```
Query  query=Query. createQuery(db);
```
By creating this object we are ready to load data Query object we need to only for Load data or select data

### 1. Selecting or Retrieving Data:

To select data from particular table we need object of Query class by using createQuery() method. There are three ways to load data from database. 
	
#### A] Single record(row) [ loadObject()] 
#### B] Multiple records (rows) [load()] 
#### C] LoadCursor

This all three types of retrieving records helps developer to easily retrieve data from database as per format in which developer  need data.( ArrayList, Object, Cursor)

#### A] Single record(row) :
We use __*loadObject()*__ method to load single row/record from database, __*loadObject()*__ method returns  Object of first record which are selected from database if data not available then it returns null.
The syntax of load method is given below 

Syntax of method:
```
public Object loadObject(Class table)
```
Example
```
Object record=query. loadObject (ExapmleTable.class);
```
Corresponding SQLite statement:
 ```
Select * from ExapmleTable
```

#### B].Multiple records (rows):
We use __*load()*__ method to load multiple data from database, load method returns __*List< Object>*__ which are selected from database if data not available then it returns empty list. 
The syntax of load method is given below 

Syntax of method:
```
public List<Object> load(Class table);
```
Example
``` 
List<Object> list=query.load(ExapmleTable.class);
```

Corresponding SQLite statement 
```
Select * from ExapmleTable
```
#### C] LoadCursor
We use __*loadCursor()*__ method to load multiple data from database, __*loadCursor()*__ method returns Cursor which are selected from database if data not available then it returns empty Cursor.

The syntax of loadCursor() method is given below. 

Syntax of method:
```
public Cursor loadCursor(Class table);
```
Example 
```
Cursor cursor =query. loadCursor (ExapmleTable.class);
````
Corresponding SQLite statement 
```
Select * from ExapmleTable
```


### 2. Inserting  Data:
 We can insert records in table by using one of the static __*insert()__* and __*insertList()*__ method of Query class. There are two ways to insert data in database. 
#### A] Insert single Record                                                                    
#### B] Insert multiple Records 

#### A] Insert single Record:
 To insert Single record in database we need to object of Object class with data to be inserted  in Table.
 Example
 ```
 Student student=new Student(01, “vishal”);	
 ```
now our data is ready to insert now we need to use static __*insert()*__ Method  of  Query class,
following is the simple syntax of insert() method.

Syntax of method:
```
public static boolean insert(Object row)
```
Example
```
Query.insert(student);
```

#### B] Insert multiple Records:
 To insert Single record in database we need to ArrayList of  Object class with data to be inserted  in Table 
Example
```
ArrayList<Student> lsitstud=new ArrayList<Student>();
lsitstud.add(new Student(01, “vishal”)); 
lsitstud.add(new Student(02, “Amar”));
```
 now our data is ready to insert now we need to use static __*insertList()*__ Method  of  Query class,
 following is the simple syntax of insertList () method.
 
Syntax of method:
```
public static boolean insertList(ArrayList rows) 
```
Example
```
Query. insertList(lsitstud);
```

### 3. Updating  Data:
We can update records in table by using static __*update()*__ of Query class. Update method is a static method of Query class the syntax of update method is given bellow.

Syntax of method:
```
public long update(Object row, String where);
```
Example

```
Query.update(new Student(01,”Rushikesh”),”Rollno=01”);
```
 By executing this query it will affect rows which matches the where condition it will update all object in database with respective to columns, this methods returns the  number of rows affected by updated query or no of rows updated query. 

### 4. Clauses:

#### A] Restriction: 
 This SQLiteBuilder tutorial explains how to use a **SQLiteBuilder WHERE condition with syntax and examples**. The SQLiteBuilder WHERE Condition is used to select particular row/rows in a SELECT, UPDATE, or DELETE statement.
**Restriction** class is used to set restriction with WHERE clause with Query object with the help of __*setRestriction()*__ method. 
The Syntax of Restriction method is as follow,
```
 public Query setRestriction(Restriction restriction);
 ```
  set restriction method return the object of Query Class and accept the parameter of restriction class.
 The following are some constructor and methods of Restriction class.
 
**Constructor:**
 Restriction class having only default constructor
Example:
```
Restriction restriction=new Restriction (); 
```
**Methods of Restriction class:**
 Restriction class having following methods which are help full to develop strong SQLite “WHERE” query, following are methods.
##### a. public Restriction addEquals(String property, String value) :
 Method is used to add “WHERE” condition with “=” given property and String value. If already any Restriction added before then it automatically add ‘AND’ Operator inside query.
 
 Syntax:
```
restriction.addEquals (“Column”,”value”);
```

Example:
```
restriction.addEquals (“Rollno”,”1”);
```
i.e.
```
   “WHERE  Rollno=’1’
```

Example: 
```
restriction.addEquals (“Dept”,”IT”);
```
i.e
```
“WHERE  Rollno=’1’ AND Dept=’IT’
```

#####  b. public Restriction  addEquals(String property, boolean value) :
 Method is used to add “WHERE” condition with “=” given property and Boolean value (true=1 and false=0). If already any Restriction added before then it automatically add ‘AND’ Operator inside query.
 
 Example:
 ```
	restriction.addEquals (“Column”,true/false)
	restriction.addEquals (“status”,true);
```
i.e 
```
WHERE  status =1
```


##### c. public Restriction  addEqualsOr(String property, String value) :
 This method is similar to addEquels() method but instead of ‘AND’ Operator it Add ‘OR’ Operator. This Method is used to add “WHERE” condition with “=” given property and String value. If already any Restriction added before then it automatically add ‘OR Operator inside query.
 
Example:
```
restriction.addEquals (“Column”,”value”);
restriction.addEquals (“Rollno”,”1”);
```
i.e
```
WHERE  Rollno=’1’
```
```
restriction.addEquals (“Dept”,”IT”);
```
i.e
```
WHERE  Rollno=’1’ OR Dept=’IT’
```

##### d. public Restriction  addEquals(String property, int value):
 Method is used to add “WHERE” condition with “=” comparison operator on given property and integer value. If already any Restriction added before then it automatically add ‘AND’ Operator inside query. 
 
Example:
```
restriction.addEquals (“Column”,value);
restriction.addEquals (“Rollno”,1);
```
i.e
```
WHERE  Rollno=1
```

```
restriction.addEquals (“Dept_id”,2);
```
i.e 

```
WHERE  Rollno=1 AND Dept_id =2
```
##### e. public Restriction  addEqualsOr(String property, int value):
 This method is similar to addEquels(String property, int value) method but instead of ‘AND’ Operator it Add ‘OR’ Operator. This Method is used to add “WHERE” condition with “=” given property and integer value. If already any Restriction added before then it automatically add ‘OR Operator inside query. 
 
Example:
```
restriction.addEquals (“Column”,value);
restriction.addEquals (“Rollno”,1);
```
i.e
```
WHERE  Rollno=’1’
```

```
restriction.addEquals (“Dept_id”,2);
```
i.e
```
WHERE  Rollno=1 OR Dept_id =2
```
##### f. public Restriction  addNotEquals(String property, String value):
 Method is used to add “WHERE” condition with “!=” conditional operator on given property and String value. If already any Restriction added before then it automatically add ‘AND’ Operator inside query. 

Example:
```
restriction.addNotEquals (“Column”,”value”);
restriction. addNotEquals (“Rollno”,”1”);
```
i.e
```
WHERE  Rollno!=’1’
```

```
restriction. addNotEquals (“Dept”,”IT”);
```

i.e 
```
WHERE  Rollno!=’1’ AND Dept!=’IT’
```
##### g. public Restriction  addNotEqualsOr(String property, String value):
 This method is similar to addNotEquals(String property, String value) method but instead of ‘AND’ Operator it Add ‘OR’ Operator. This Method is used to add “WHERE” condition with “!=” conditional operator on given property and String value. If already any Restriction added before then it automatically add ‘OR Operator inside query.
 
Example:
```
restriction.addNotEqualsOr (“Column”,”value”);
restriction. addNotEqualsOr (“Rollno”,”1”);
```
i.e
``` WHERE  Rollno!=’1’
```

```
restriction. addNotEqualsOr (“Dept”,”IT”);
```
i.e
```
WHERE  Rollno!=’1’ OR Dept!=’IT’
```

##### h. public Restriction  addNotEquals(String property, int value):
 Method is used to add “WHERE” condition with “!=” conditional operator on given property and Integer value. If already any Restriction added before then it automatically add ‘AND’ Operator inside query. 
 
Example:
```
restriction.addNotEquals (“Column”,value);
restriction. addNotEquals (“Rollno”,1);
```
i.e
 ```
 WHERE  Rollno!=1
 ```
 ```
restriction. addNotEquals (“Dept_id”,2);
```
i.e
```
WHERE  Rollno!=1’ AND Dept_id!=2
```
###### i. public Restriction  addNotEqualsOr (String property, int value):
 Method is used to add “WHERE” condition with “!=” conditional operator on given property and Integer value. If already any Restriction added before then it automatically add ‘OR Operator inside query. 
 
 Example:
 ```
restriction.addNotEqualsOr(“Column”,value);
restriction. addNotEqualsOr (“Rollno”,1);
```
i.e
```
WHERE  Rollno!=1
```
```
restriction. addNotEqualsOr (“Dept_id”,2);
```
i.e
```
WHERE  Rollno!=1’ OR Dept_id!=2
```
Following Are Some list of Methods are available in Restriction class which are equivalent to SQL Where condition As,
##### j. public Restriction addGT(String property, int value):
 Method is used to add “WHERE” condition with “>” conditional operator on given property and Integer value. if Already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### k. public Restriction addGTE(String property, String value):
 Method is used to add “WHERE” condition with “>=” conditional operator on given property and String value. if Already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### l.public Restriction addGTOr(String property, String value):
 Method is used to add “WHERE” condition with “>” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.


##### m. public Restriction addLT(String property, int value):
 Method is used to add “WHERE” condition with “<” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘AND’ operator inside query.


##### n. public Restriction addLTOr (String property, int value)
 Method is used to add “WHERE” condition with “<” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.

##### o. public Restriction addGTE(String property, int value)
 Method is used to add “WHERE” condition with “>=” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### p. public Restriction addGTEOr(String property, int value)
Method is used to add “WHERE” condition with “>=” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.
 

##### q. public Restriction addLTE(String property, int value)
 Method is used to add “WHERE” condition with “<=” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.


##### r. public Restriction addLTEOr(String property, int value)
 Method is used to add “WHERE” condition with “<=” conditional operator on given property and Integer value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.


##### s. public Restriction addLike (String property, String  value) 
 Method is used to add “WHERE” condition with “LIKE” conditional operator on given property and String value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### t. public Restriction addLikeOr (String property, String  value)
 Method is used to add “WHERE” condition with “LIKE” conditional operator on given property and String value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.

##### u. public Restriction addNotLike (String property, String  value)
 Method is used to add “WHERE” condition with “ NOT LIKE” conditional operator on given property and String value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### v. public Restriction addNotLikeOr (String property, String  value)
 Method is used to add “WHERE” condition with “NOT LIKE” conditional operator on given property and String value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.


##### w. public Restriction addIN(String property, String  value):
 Method is used to add “WHERE” condition with “IN” conditional operator on given property and String of comma separated list of value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.


##### x. public Restriction addINOr(String property, String  value):
 Method is used to add “WHERE” condition with “IN” conditional operator on given property and String of comma separated list of value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.


##### y. public Restriction addNotIN(String property, String  value):
 Method is used to add “WHERE” condition with “NOT IN” conditional operator on given property and String of comma separated list of value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.

##### z. public Restriction addNotINOr(String property, String  value)
 Method is used to add “WHERE” condition with “NOT IN” conditional operator on given property and String of comma separated list of value. If already any restriction added before then automatically add ‘OR’ Operator inside Query.


##### aa. public Restriction addBetween(String property, String start, String end)
Method is used to add “WHERE” condition with “BETWEEN” condition on given property and String value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.


##### bb. public Restriction addBetweenOr(String property, String start, String end)
Method is used to add “WHERE” condition with “BETWEEN” condition on given property and String value. If already any restriction added before then automatically add ‘OR Operator inside Query.

##### cc. public Restriction addNotBetween(String property, String start, String end)
Method is used to add “WHERE” condition with “NOT BETWEEN” condition on given property and String value. If already any restriction added before then automatically add ‘AND’ Operator inside Query.


##### dd. public Restriction addNotBetweenOr(String property, String start, String end)
Method is used to add “WHERE” condition with “NOT  BETWEEN” conditional operator on given property and String value. If already any restriction added before then automatically add ‘OR Operator inside Query.


##### ee. public Restriction addIsNull (String property)
 Method is used to add “WHERE” condition with “IS NULL” conditional operator on given property and String value. If already any restriction added before then automatically add “AND” Operator inside Query.


##### ff. public Restriction addIsNotNull (String property)
Method is used to add “WHERE” condition with “IS NOT NULL” conditional operator on given property and String value. If already any restriction added before then automatically add “AND” Operator inside Query


##### gg. public Restriction Clear()
Method is used to clear Restriction of Restriction object in the 





### 5. Projection:
 This SQLiteBuilder tutorial explains how to use a SQLiteBuilder Projection  with syntax and examples. The SQLiteBuilder Projection is used to select particular column/columns in a SELECT statement.
**Projection** class is used to set projection  with Query object with the help of **setProjection()** method. 

**The Syntax of setProjection() method is as follow,**
```
public Query setProjection(Projection projection);
```
setProjection() method return the object of Query Class and accept the parameter of Projection class. 

The following are some constructor and methods of Projection class.

**Constructor:**
 Projection class having only default constructor 
Example:
```
Projection restriction=new Projection(); 
```

**Methods of Projection class:**

Projection class having following methods which are help full to develop strong SQLite “SELECT” query, following are methods.

##### a. public Projection avg(String property) :
 Method is used to find Average of particular column. 

Example:
```
projection.avg( “collumnname”);
projection. avg (“Rollno”);
query.setProjection(projection);
```
i.e

```
SELECT  avg(Rollno) FROM  Student
```

##### b. public Projection count(String property) :
Method is used to apply count() function on  particular column. 

Example:
```
projection.count( “projectionName”);
projection. count (“Rollno”);
query.setProjection(projection);
```
i.e
```
SELECT  count(Rollno) FROM  Student
```

##### c. public Projection max(String property) :
 Method is used to apply max() function on  particular column. 
 
Example:
```
projection.max( “projectionName”);
projection. max (“Rollno”);
query.setProjection(projection);
```
i.e
```
SELECT  max(Rollno) FROM  Student
```

##### d. public Projection min(String property) :
 Method is used to apply min() function on  particular column. 

Example:
```
projection.min( “projectionName”);
projection. min (“Rollno”);
query.setProjection(projection);
```
i.e
```
SELECT  min(Rollno) FROM  Student
```

##### e. public Projection min(String property) :
 Method is used to apply min() function on  particular column. 
Example:
```
projection.min( “projectionName”);
projection. min (“Rollno”);
query.setProjection(projection);
```
i.e
```
SELECT  min(Rollno) FROM  Student
```
##### f. public Projection rowCount(String property) :
Method is used to apply rowCount() function on  particular column. 

Example:
```
projection.rowCount();
projection. rowCount();
query.setProjection(projection);
```
i.e
```
SELECT  count(*) FROM  Student
```
##### g. public Projection sum(String property) :
 Method is used to apply sum() function on  particular column. 

Example:
```
projection. sum ( “projectionName”);
projection. sum (“Rollno”);
query.setProjection(projection);
```
i.e
```
SELECT  sum (Rollno) FROM  Student
```

##### h. public Projection group_concat(String property) :
 Method is used to apply group_concat () function on  particular column. 

Example:
```
projection. group_concat ( “projectionName”);
projection. group_concat (“Rollno name”);
query.setProjection(projection);
```
i.e 
```
SELECT  group_concat (Rollno name) FROM  Student
```


##### i. public Projection column (String property) :
Method is used to add column to projection list. 

Example:
```
projection.column( “projectionName”);
projection.column(“Rollno”);
projection.column(“name”);
query.setProjection(projection);
```
i.e 
```
SELECT  Rollno,name  FROM  Student
```

### 6. Sorting:
This SQLiteBuilder tutorial explains how to use a SQLiteBuilder Sorting  with syntax and examples. The SQLiteBuilder Order is used to sort particular column/columns in a SELECT statement.
Order class is used to set sorting with Query object with the help of setOrder() method.

The Syntax of setOrder () method is as follow,
```
public Query setOrder(Order order)
```
setOrder () method return the object of Query Class and accept the parameter of Order class.
The following are some constructor and methods of Order  class.

**Constructor:**
Order  class having only default constructor 

Example:
```
Order  order=new Order (); 
```
**Methods of Order class:**
 Order class having following methods which are help full to apply sorting on SQLite “SELECT” query, following are methods.
##### a. public Order  setDesc(String columnname):
 Method is used to Order records in Descending Oder on particular column. Column name passed as parameter. You can add multiple column sorting also by invoking this method multiple times.  
Example:

order.setDesc(“Rollno”);

i.e   “SELECT  * FROM  Student ORDERBY Rollno DESC”

b.	public Order  setAsc(String columnname):
Method is used to Order records in Ascending Oder on particular column. Column name passed as parameter. You can add multiple columns sorting also by invoking this method multiple times.  
Example:
order. setAsc (“Rollno”);

i.e   “SELECT  * FROM  Student ORDERBY Rollno”

c.	public Order  clear():
Method is used to clear Order that applied Oder object with  particular column..  
Example:
Order.clear();


7.	Grouping:
This SQLiteBuilder tutorial explains how to use a SQLiteBuilder Grouping with syntax and examples. The SQLiteBuilder Group class is used to collect data across multiple records and group the results by one or more columns. Grouping is done while Loading Result.
Group class is used to set grouping with Query object with the help of setGroup() method. The Syntax of setGroup() method is as follow,
public Query setGroup(Group group);
setGroup() method return the object of Query Class and accept the parameter of Group class. The following are some constructor and methods of Group class.
Constructor:   
Group class having only default constructor 
Example:
Group group=new Group(); 

Methods of Group class:
Group class having following methods which are help full to is used to collect data across multiple records and group the results by one or more columns, following are methods.
a.	public Group setGroup (String expression):
Method is used to Group records with respective expression. Expression passed as parameter. You can add multiple expression grouping also by invoking this method multiple times.  
 Example:
group.setGroup(“Rollno”);

i.e   “SELECT  * FROM  Student GROUP BY Rollno”












