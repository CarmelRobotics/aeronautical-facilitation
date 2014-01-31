aeronautical-facilitation
=========================

Code for the [FRC][frc] Game `Aerial Assist 2014` used by FIRST Team 2035, the Rockin' Bots. 

This project is being done in conjunction with [Dazzled][dazzled].

Software download URLs
----------------------
* [Netbeans 7.4][netbeans]
* [Netbeans FRC Plugins][netbeansplugins] 
* [Git for Windows][git]
* [SmartGit][smartgit]

Reference documentation
-----------------------
* [FRC Manual][frcmanual]
* [WPILIB Javadoc][javadoc]
* [WPI Screen steps][wpiscreensteps]
* [Markdown syntax][markdown]
* [JD's vision paper][jdpaper]
* [Git tutorial][gittutorial]
* [Networktables protocol specification][ntspec]
* [Networktables python implementation][ntpy]

Useful websites
---------------
* [Chief Delphi][chiefdelphi]
* [FRC Blog][frcblog]
* [FRC Game video][frcvideo]

[frc]: http://www.usfirst.org/roboticsprograms/frc
[frcmanual]: http://frc-manual.usfirst.org/
[frcblog]: http://www.usfirst.org/roboticsprograms/frc/blog
[frcvideo]: https://www.youtube.com/watch?v=oxp4dkMQ1Vo
[netbeans]: https://netbeans.org/
[netbeansplugins]: http://wpilib.screenstepslive.com/s/3120/m/7885/l/79405-installing-the-java-development-tools
[javascreenstep]: http://wpilib.screenstepslive.com/s/3120/m/7885/l/79405-installing-the-java-development-tools
[git]: http://msysgit.github.io/
[smartgit]: http://www.syntevo.com/smartgithg/
[chiefdelphi]: http://www.chiefdelphi.com/forums/portal.php
[frcmanual]: http://frc-manual.usfirst.org/
[frcblog]: http://www.usfirst.org/roboticsprograms/frc/blog
[javadoc]: http://www.wbrobotics.com/javadoc/edu/wpi/first/wpilibj/package-summary.html
[wpiscreensteps]: http://wpilib.screenstepslive.com/s/3120
[markdown]: http://daringfireball.net/projects/markdown/basics
[jdpaper]: http://www.chiefdelphi.com/media/papers/2854
[gittutorial]: http://try.github.io/levels/1/challenges/1
[ntspec]: http://firstforge.wpi.edu/sf/docman/do/downloadDocument/projects.wpilib/docman.root/doc1318
[ntpy]: https://github.com/Team3574/2013VisionCode/blob/master/src/nt_client.py
[dazzled]: https://github.com/CarmelRobotics/dazzled

Daily activities
================
1. Start smartgit
1. Pull latest content from github
1. Start netbeans
1. Check the TODO below
1. Verify you are in an appropriate branch name for what you want to work on.  You do this by looking at the Smartgit log button.
1. Make code changes as necessary.
1. Commit in Smartgit
1. Push in Smartgit

TODO 
====

1. Add compressor object.  
1. There are unused objects in OI.java that need to be added!
1. Continue work on autonomous (see notes on whiteboard)
1. Work on the javadoc throughout the project!  In the menu bar, run Tools-Analyze Javadoc 
1. BUG: BlockerUp and BlockerDown both use blocker.setBlockerRaise()
1. Roller branch still needs work (Kat was working on this)
1. Blocker.java uses hard coded 1.0 and -1.0 values for raise/lower.  Only one should be defined in RobotMap (and then the second one uses the negative of it)
1. DriveTrain.java defines variables that it should not.
1. Launcher.java uses hard coded true and false values for launch/pass/retract.  Only one should be defined in RobotMap (and the other usage should be the logical not of it).
1. Roller.java uses hard coded true and false values for raiseRoller and lowerRoller.  Only one should be defined in RobotMap (and the other usage should be the logical not of it).
1. We could make our own screen captures website of our daily workflow.

