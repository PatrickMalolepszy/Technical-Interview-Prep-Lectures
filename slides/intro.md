## How to get an Internship
## (or full time job)
Slides based on David Valleau's presentations from 2016

Slides hosted @ [malolepp.myweb.cs.uwindsor.ca](http://malolepp.myweb.cs.uwindsor.ca)



## About Me
- Interned at Amazon Seattle in Summer 2017.
- Returning to work full time in Jan 2018.

![](img/amazon_logo.png)



## Why get an Internship?
- Resume Builder
- $$$
- Travel
- Easier "way in" to company you are interested in



## Applications
- Fall is the start of the summer internship hiring cycle for most big companies.
- Browse listings: indeed, linkedin, angellist, glassdoor, intern.supply
- Apply to local companies



## Getting an Interview
- Good resume
- Referral
- Network with recruiters (Connect at hackathons, recruiting events, etc)



## Resume Advice
- Keep it to single page
- Find a good resume template online (nothing too fancy)
- Use short bullets rather than large blocks of text
- Talk about your accomplishments, and whenever possible try to quantify them using real numbers
- Use action verbs (designed, developed, created, etc.)
- List your personal projects
- We are in an industry where we have the ability to create our own work experience. Take advantage of this! Work on whatever interests you and put it on Github and on your resume!


Learn more here: [https://www.careercup.com/resume](https://www.careercup.com/resume)



## Doing well on the interview
- Mainly a technical challenge
- Attitude and strong communication skills still matter!




## Example Problem:
Given a two dimensional matrix of booleans, a coordinate, and a length x, determine the number of true values within a square around the coordinate. The distance from the coordinate and the edge of the square is x.

![](img/example2.png)



## A solution
```java
int countBooleanSquare(boolean[][] matrix, int x, int y, int length) {
    int count = 0;
    for (int i = x - length ; i <=  x + length ; i++) {
        for (int j = y - length ; j <= y + length ; j++) {
            if (matrix[j][i]) count++;
        }
    }
    return count;
}
```
What is wrong with this code?



## Check your input!
```java
if (matrix == null) {
    // What should we do when input is not valid?
}
```



```java
if (matrix == null) {
    return 0;
}
```

```
if (matrix == null) {
    return -1;
}
```

```
if (matrix == null) {
    throw new IllegalArgumentException
    	("null matrix passed to countBooleanSquare"); 
}
```
Know your language well, what is the standard in that language?



## Edge Cases!
![](img/edgeCase.png)




```java
public static int countBooleanSquare(boolean[][] matrix, int x, int y, int length) {

	if (matrix == null) {
	    throw new IllegalArgumentException
	            ("null matrix passed to countBooleanSquare");
	}

	int height = matrix.length;
	int width = matrix[0].length; // Does this always work?

	// Assume coordinates given as index:
	if (x < 0 || x >= width || y < 0 || y >= height) { 
	    throw new IllegalArgumentException(
	            String.format("Coordinates (%d,%d) outside of " +
	                    "matrix of dimensions (%d,%d)", x, y, width, height));
	}

	int startX = x - length < 0 ? 0 : x - length;
	int startY = y - length < 0 ? 0 : y - length;
	int endX = x + length >= width ? width - 1 : x + length;
	int endY = y + length >= height ? height - 1 : y + length;

	int count = 0;
	for (int i = startX ; i <= endX ; i++) {
	    for (int j = startY ; j <= endY ; j++) {
	        if (matrix[j][i]) count++;
	    }
	}
	return count;
}
```



## Review
- Do not assume correct input
- Communicate complexity
- Know your language
- Watch out for edge cases
- Solve the problem!



## Q & A



## Thank you!


Good luck with any interviews and see you next week!