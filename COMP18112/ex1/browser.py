#!/usr/bin/env python

import urllib

url = "http://studentnet.cs.manchester.ac.uk/ugt/COMP18112/page3.html"
data = urllib.urlopen(url)
tokens = data.read().split()

for count in range(0, len(tokens)):
    if tokens[count] == "<title>":
        tStart = count
        tStart = tStart + 1
    elif tokens[count] == "</title>":
        tEnd = count 
        print "Page Title : " + (' '.join(tokens[tStart:tEnd]))
    if tokens[count] == "<h1>":
        hStart = count
        hStart = hStart + 1
    elif tokens[count] == "</h1>":
        hEnd = count
        print "HEADING: " + (' '.join(tokens[hStart:hEnd]))
    if tokens[count] == "<p>":
        pStart = count
        pStart = pStart + 1
    if tokens[count] == "<em>":
        tokens[count] = "\033[1m"
    elif tokens[count] == "</em>":
        tokens[count] = "\033[0;0m"
    if tokens[count] == "</p>":
        pEnd = count
    if tokens[count] == "<a":
        link = count
        link = link 
        print "Paragraph: " + (' '.join(tokens[pStart:link])) + " " + (' '.join(tokens[(link + 2):(link + 3)]))
    elif tokens[count] == "</p>":
        pEnd = count
        print "Paragraph: " + (' '.join(tokens[pStart:pEnd]))
        
          


