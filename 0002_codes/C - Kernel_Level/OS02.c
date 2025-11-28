#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * OS02 : path breakdown tool
 *
 * This program:
 * - reads the PATH environment variable
 * - splits it into separate directories
 * - prints each directory on a new line
 */

int main(void) {
    const char *path = getenv("PATH");

    printf("=========================================\n");
    printf("              OS02 - path                \n");
    printf("=========================================\n");

    if (path == NULL) {
        printf("PATH variable not found\n");
        printf("=========================================\n");
        return 1;
    }

    /* make a copy of PATH because strtok modifies the string */
    char *path_copy = malloc(strlen(path) + 1);
    if (path_copy == NULL) {
        printf("memory allocation failed\n");
        return 1;
    }
    strcpy(path_copy, path);

    printf("directories in PATH:\n\n");

    /* split using ':' on linux/mac, ';' on windows */
    const char *delimiter;

#if defined(_WIN32) || defined(_WIN64)
    delimiter = ";";
#else
    delimiter = ":";
#endif

    char *token = strtok(path_copy, delimiter);

    while (token != NULL) {
        printf("%s\n", token);
        token = strtok(NULL, delimiter);
    }

    free(path_copy);

    printf("\n=========================================\n");

    return 0;
}
