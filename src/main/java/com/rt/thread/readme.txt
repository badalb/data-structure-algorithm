Deadlock Prevention
-------------------
-------------------
	Lock Ordering
	-------------
	Deadlock occurs when multiple threads need the same locks but obtain them in different order.
	If you make sure that all locks are always taken in the same order by any thread, deadlocks cannot occur. 
	
	Lock Timeout
	------------
	Another deadlock prevention mechanism is to put a timeout on lock attempts meaning a thread trying to 
	obtain a lock will only try for so long before giving up. If a thread does not succeed in taking all 
	necessary locks within the given timeout, it will backup, free all locks taken, wait for a random 
	amount of time and then retry. The random amount of time waited serves to give other threads trying 
	to take the same locks a chance to take all locks, and thus let the application continue running without 
	locking.

Deadlock Detection
------------------
------------------

	Deadlock detection is a heavier deadlock prevention mechanism aimed at cases in which lock ordering isn't 
	possible, and lock timeout isn't feasible.
	
	Every time a thread takes a lock it is noted in a data structure (map, graph etc.) of threads and locks. 
	Additionally, whenever a thread requests a lock this is also noted in this data structure.
	
	When a thread requests a lock but the request is denied, the thread can traverse the lock graph to check 
	for deadlocks. For instance, if a Thread A requests lock 7, but lock 7 is held by Thread B, then Thread A 
	can check if Thread B has requested any of the locks Thread A holds (if any). If Thread B has requested so, 
	a deadlock has occurred (Thread A having taken lock 1, requesting lock 7, Thread B having taken lock 7, 
	requesting lock 1).

So what do the threads do if a deadlock is detected?
---------------------------------------------------
---------------------------------------------------
	
	One possible action is to release all locks, backup, wait a random amount of time and then retry. 
	This is similar to the simpler lock timeout mechanism except threads only backup when a deadlock has 
	actually occurred. Not just because their lock requests timed out. However, if a lot of threads are 
	competing for the same locks they may repeatedly end up in a deadlock even if they back up and wait.
	
	A better option is to determine or assign a priority of the threads so that only one (or a few) thread 
	backs up. The rest of the threads continue taking the locks they need as if no deadlock had occurred. 
	If the priority assigned to the threads is fixed, the same threads will always be given higher priority. 
	To avoid this you may assign the priority randomly whenever a deadlock is detected.
	
	
Causes of Starvation in Java
----------------------------
----------------------------

	The following three common causes can lead to starvation of threads in Java:
	Threads with high priority swallow all CPU time from threads with lower priority.
	Threads are blocked indefinately waiting to enter a synchronized block, because other 
	threads are constantly allowed access before it.
	
	Threads waiting on an object (called wait() on it) remain waiting indefinitely because other 
	threads are constantly awakened instead of it.