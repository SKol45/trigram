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
*trigram application having a class called TrigramGenerator.java is responsible to read a input file, generate all possible trigrams and write newly generated swash-buckling scientific adventure data in a file with the help of another model class trigram.java.


Unit test cases are executed and validated with :
===============================================

Input files: tom_swift_under_the_milkwood.txt
Output files: tom_swift_under_the_milkwood_new_version.txt

Risks:
=====
Can expect outofmemory error for few edge cases

Future improvements:
===================
1.Logger implementation

2.Concurrency implelemntation

3.SonarQube implementation
