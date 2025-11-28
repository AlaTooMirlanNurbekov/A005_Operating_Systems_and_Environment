#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * OS04 : basic command interpreter
 *
 * This program:
 * - shows a simple command prompt
 * - reads a command from the user
 * - runs the command using the operating system
 * - exits when the user types "exit" or "quit"
 */

int main(void) {
    char command[256];

    printf("=========================================\n");
    printf("        OS04 - basic interpreter         \n");
    printf("type commands to run them\n");
    printf("type 'exit' or 'quit' to leave\n");
    printf("=========================================\n");

    while (1) {
        printf("os04> ");

        if (fgets(command, sizeof(command), stdin) == NULL) {
            printf("\ninput error, exiting\n");
            break;
        }

        /* remove newline at the end if present */
        char *newline = strchr(command, '\n');
        if (newline != NULL) {
            *newline = '\0';
        }

        /* ignore empty input */
        if (command[0] == '\0') {
            continue;
        }

        /* check for exit commands */
        if (strcmp(command, "exit") == 0 || strcmp(command, "quit") == 0) {
            printf("exiting os04\n");
            break;
        }

        /* run the command using the system shell */
        int result = system(command);

        if (result == -1) {
            printf("could not run command\n");
        }
    }

    printf("=========================================\n");

    return 0;
}
