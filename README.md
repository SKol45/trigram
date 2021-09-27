# trigram
Project name : trigram
============


From source file, create a new file with the help of trigrams.  Trigram are created for every 3 adjacent words by combining 1st and 2nd word as key and 3rd word as value.


For example check below use case:
===============================

Input file with stream of : I wish I may I wish I might


Trigrams : [["I wish", "I"], ["wish I", "may"], ["I may", "I"], ["may I", "wish"], ["I wish", "I"], ["wish I", "might"]]


More simplified trigrams:


"I wish" => ["I", "I"]

"wish I" => ["may", "might"]

"may I"  => ["wish"]

"I may"  => ["I"]


New file with expected trigrams stream case 1 : I wish I may I wish I may I wish I might



New file with expected trigrams stream case 2 : wish I might
 


New file with expected trigrams stream case 3 : wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I might 


Technical stack used : Java 11, Junit
====================

Third party libraries used : None
==========================

IDE : IntelliJ
===

Build tool : Maven 
==========

Exptected input : File
===============

Expected output : File
===============

Solution:
========
--

Unit test cases are executed and validated with :
===============================================

--

Risks:
=====
--

Future improvements:
===================
--
