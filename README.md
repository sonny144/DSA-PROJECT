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

### Documentation notes

- Some algorithms present in Section B may not correlate one-to-one with entries in Section A due to nuance in implementation
- `old_ref_flow.png` in root of `SectionA` contains general use flow created for prev. assignment as reference

## Section B

The program is written in Java, built using Maven, using the MVCS (model, view, controller, service) architecture industry standard.  

It is an emulation of a music player, not a production player. This is done for demo purposes; the program is used primarily to demonstrate the linkedlist. The program provides verbose output in support of this goal.  
Though not immediately functional as presented in the assignment, the program has been designed in such a way that it can easily be modified to provide actual music output; libraries to play these files are, however, not provided as dependencies.  

A GUI is not provided due to time constraints; all features are accessed using command line.  

For the purposes of organisation, as the program is relatively small, the packages are organised such that every class is contained in its relevant feature (e.g. `playlist`) as opposed to separated by class, model, service, etc.  

In every feature package should contain a class named appropriate to its parent folder, being the model; the controller/services are named (individually) the same across all folders, but separated by package.  

A feature may include an `init` class, which contains functions to initialise the feature.  

The program may be run either by directly running `App.java` located under `/SectionB/src/main/java/com/dsaplayer/` or building from source using Maven and running the generated binaries (done automatically under default Maven settings).  

### Build instructions

To build from source, input:
`mvn clean compile package -f "$<projdir>/SectionB/pom.xml"`  
where `$<projdir>` is the path to the root of your clone.  

### Program notes

- `DLL` = Doubly Linked List (not lib)
- The function for adding songs to playlist is contained in `Playlist.java` as it is necessary for the class to refer to itself to alter entries in the DLL
- `Service` files include all functions for managing a feature unless otherwise specified, such as in the case of above
- `Playlist` is an obj with a name and x number of `PlaylistNode`s; `plGlobal` is an arraylist with y number of `Playlist`s
- All playlists are stored in `plGlobal`

## Members

### Group 2

```text
222094494 - Mark Nyambe
222112425 - Christy Diamonds
222119187 - Treasure Kamwi
222062568 - Ache Victor
222125152 - Kevin Iipopi Wonena
222046880 - Festus Alpheus
222017813 - David Natangwe Mbidi
```

### Group 5

```text
222125373 - Elijah Hilukiluah
222017740 - Ethan Cosburn
```
