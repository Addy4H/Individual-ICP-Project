# Individual-ICP-Project

For this code to work, one has to pass in an input file, airport file, airline file and the route file in a function call of the FileReader class in the main class. The information to the latter 3 were retrieved from the website https://openflights.org/data.html

For the input file, it consists of 2 lines representing the city and country for the source and destination. The entries in the file are taken as follows:

SourceCity, SourceCountry

DestinationCity, DestinationCountry


The lines must have a whitespace in between the comma and the source country. The names should also be written in titlecase.

After, one must call the readAllFiles method in the FileReader class. 
Next, create an instance of the FindRoute class and call the method writeOutputToFile. 

After this, your output file will have the resulting path if there is indeed a route. 


All the best!!
