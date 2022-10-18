# DSA Assignment

This repository contains documentation for logic and functionality for a music player in Section A as well as the practical implementation written in Java in Section B.  

The repo's directory format is as follows:

```text
SectionA                // All subdirs of SectionA refer to module names
| PlaylistManager       // Container for modules; for easy org
| | AddSong
| | | flow.png          // Sample; may be named differently
| | | pseudocode.txt
| | RemoveSong
| | | ...
| PlaylistPlayer
| | PlayShuffle
| | | ...
| SongSearch            // Not all modules contain sub-modules; they may exist on their own like this one
| | flow.png
| | pseudocode.txt
| ...

SectionB                // May contain configuration files, such as pom.xml; these are valuable to read
| src                   // Source code of software demo
| | ...
| ...
```

## Section A

Note that some algorithms present in Section B may not correlate one-to-one with entries in Section A due to nuance in implementation.

## Section B

The program is written in Java, built using Maven, using the MVCS (model, view, controller, service) architecture industry standard.  

For the purposes of organisation, as the program is relatively small, the packages are organised such that every class is contained in its relevant feature (e.g. `playlist`) as opposed to separated by class, model, service, etc.  

In every feature package should contain a class named appropriate to its parent folder, being the model; the controller/services are named (individually) the same across all folders, but separated by package.  

A feature may include an `init` class, which contains functions to initialise the feature.  

The program may be run either by directly running `App.java` located under `/SectionB/src/main/java/com/dsaplayer/` or building from source using Maven and running the generated binaries (done automatically under default Maven settings).
To build from source, input:
`mvn clean compile package -f "$<projdir>/SectionB/pom.xml"`  
where `$<projdir>` is the path to the root of your clone.  

Program notes:

- `DLL` = Doubly Linked List (not lib)
- The function for adding songs to playlist is contained in `Playlist.java` as it is necessary for the class to refer to itself to alter entries in the DLL
