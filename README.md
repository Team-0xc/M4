# CIS3750-Team-0xC

Thing | Style
---|---
Class|UpperCamelCase
Variables|camelCase
Methods|UpperCamelCase
Globals|CAPITALS_WITH_UNDERSCORES

Other:
- Curly braces same line (see below)


```
if (exp) {
  Do Stuff
}
else {
  Do More Stuff
}
```

Change List (From M3)
---

Section:
- Added IsMeetingConflict method to compare Sections

Transcript:
- Renamed hasPassedCourse to HasPassed

Timetable:
- Added HasMeetingConflict method to compare Timetable Sections with a Section

Meeting:
- Changed getTimeslot to IsConflict. Check for timeslot conflict is now Meeting's responsibility

Waitlist:
- Removed capacity and id fields as they are unnesscary

Student:
- Changed constructor to take a student counselor
- Added more methods