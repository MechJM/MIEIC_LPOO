## Smells
1. There seem to be 2 **data clumps** (password/username and phone/name)
2. The worker class seems to be doing some work that should belong lo LoginInfo (Middleman?)

## Refactorings
1. Create a class to replace each clump (Extract class and Introduce Parameter Object)
2. Moved login method from Worker to LoginInfo (Remove Middleman?)