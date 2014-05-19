vmtest
======

- Collections: (25%)  project merge

Write a java merge class that will merge two sorted collections of the same kind into a single sorted collection. You need to think of how to design this class in a generic form and efficiently.

- Concurrency: (15%)  project blockingqueue

Use java concurrency packages to write a queue that supports multiwriter and multireader, i.e. the writer pushes the stuff into the queue and the reader pops the stuff out the queue. All the writer's stuff can't be lost and must be into the queue, and each reader can't pops out the same stuff. Think of how you would simulate the situation and perform the testing. Using the java blocking queue is not allowed.

- OO Design: (20%) project Painting

Consider the following design problem and come up with a class hierarchy: Given a drawing mechanism, we always need to invoke some preprocessing before drawing, and postprocessing after drawing, and also each user will draw different shapes like circle, square, whatever he/she likes. Now, make an OO design of classes so that the routine preprocessing/postprocessing can be hidden, and the user can supply whatever the shape he/she wants to draw. Hint: consider a design pattern called Template Pattern.

- DB Project: (40%) project ssb

Consider that we are a service provider to provide customers different services. Each customer can subscribe to mulitiple service and each service can be subscribed to by multiple customers. Come up a database schema to model the service-customer relationship. And use java/html/tomcat/db of your choice to implement a simple web app that will display a customer's subscriptions and let the customer subscribe to a new service, modify or delete a subscribed service. Hints: introduce a join table to model the many to many subscription relationship. Using the open source java db mapping packages such as hibernate, ibatis, and others are most desirable.  Good looking GUI is not required.

NOTE:
1.the vmtest project is a parent project which consist of 4 module projects which correspond to above 4 tasks

2.project profile: JDK6 Maven Spring MySql5

3.ssb.sql contains sql schema and initial data.

4.each project except ssb has unit test for demonstration, but unit test for blockingqueue can only be running as Java App since I don't know why JUnit can not start multi-thread.