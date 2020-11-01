# OSRS Bingo

OSRS clan bingo, re-imagined.

## Setup

To start up, source the environment variables,
then start the database with docker-compose.

```shell script
source .env.local
docker-compose up -d
```

## Discord Bot Commands
```shell script
!bingo create-event <event-name> : Creates a new bingo event which acts as a session for all below commands.
!bingo start-event <event-name> <start-date> <finish-date> : Starts the event and begins the countdown.
!bingo finish-event <event-name> : Finishes the event

!bingo create-team <team-name> : Creates a private voice channel and creates a private team channel where players should post !bingo mark at.
!bingo team-add <team-name> <discord-user-name> : Adds the specified player to team.
!bingo team-remove <team-name> <discord-user-name> : Removes the specified player from team.

!bingo team-join <team-name> : Join a certain team.
!bingo team-leave : Leave the team.

!bingo time : Displays how much time left for the bingo event.
!bingo levels : Displays all available bingo item levels and their points.
!bingo add-item <level> <bingo-item> : Adds an item and assigns a level (points).
!bingo remove-item <bingo-item> : Removes the item from bingo
!bingo items : View all bingo items (maybe generate a PNG with bingo board and post in channel?)

!bingo mark <bingo-item> : Marks a specific item off for the player. (Save timestamp so that timings can be compared)
!bingo unmark <bingo-item> : Unmarks a specific item for the player.
```
