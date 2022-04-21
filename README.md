# Java-MilitaryElite
Java OOP (interfaces)

Create the following class hierarchy:

Soldier – general class for soldiers, holding id, first name and last name.

Private – lowest base soldier type, holding the field salary(double).

LeutenantGeneral – holds a set of Privates under his command.

SpecialisedSoldier – general class for all specialised soldiers – holds the corps of the soldier.

Engineer – holds a set of repairs. A repair holds a part name and hours worked(int).

Commando – holds a set of missions. A mission holds code name and a state (inProgress or Finished). A mission can be finished through the method CompleteMission().

Spy – holds the code number of the spy.

Extract interfaces for each class. (e.g. ISoldier, IPrivate, ILeutenantGeneral, etc. Each class should implement its respective interface. Validate the input where necessary (corps, mission state) - input should match exactly one of the required values, otherwise it should be treated as invalid. In case of an invalid mission state only the mission should be skipped.

You will receive from the console an unknown amount of lines containing information about soldiers until the command “End” is received. The information will be in one of the following formats:

Private: “Private <id> <firstName> <lastName> <salary>”

LeutenantGeneral: “LeutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id> … <privateNId>” where privateXId will always be an Id of a private already received through the input.

Engineer: “Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> … <repairNPart> <repairNHours>” where repairXPart is the name of a repaired part and repairXHours the hours it took to repair it (the two parameters will always come paired).

Commando: “Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> … <missionNCodeName> <missionNstate>” a missions code name, description and state will always come together.

Spy: “Spy <id> <firstName> <lastName> <codeNumber>”

Define magic method __toString() in all classes to print detailed information about the objects.
=======================================================================================================
Example Input:

Private 1 Pesho Peshev 22.22

Commando 13 Stamat Stamov 13.1 Airforces

Private 222 Toncho Tonchev 80.08

LeutenantGeneral 3 Joro Jorev 100 222 1

End
=========================================================================================================
Output:

Name: Pesho Peshev Id: 1 Salary: 22.22

Name: Stamat Stamov Id: 13 Salary: 13.10

Corps: Airforces

Missions:

Name: Toncho Tonchev Id: 222 Salary: 80.08

Joro Jorev Id: 3 Salary: 100.00

Privates:

  Name: Toncho Tonchev Id: 222 Salary: 80.08

  Name: Pesho Peshev Id: 1 Salary: 22.22
