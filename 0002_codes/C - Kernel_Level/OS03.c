#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#if defined(_WIN32) || defined(_WIN64)
    #include <direct.h>
    #define get_cwd _getcwd
    #define change_dir _chdir
#else
    #include <unistd.h>
    #define get_cwd getcwd
    #define change_dir chdir
#endif

/*
 * OS03 : working directory navigator
 *
 * This program:
 * - prints the current working directory
 * - asks the user for a new directory
 * - tries to change to the new directory
 * - prints the updated working directory or an error message
 */

int main(void) {
    char current_dir[1024];
    char new_dir[1024];

    printf("=========================================\n");
    printf("           OS03 - working dir            \n");
    printf("=========================================\n");

    /* get and print current working directory */
    if (get_cwd(current_dir, sizeof(current_dir)) == NULL) {
        printf("could not get current directory\n");
        printf("=========================================\n");
        return 1;
    }

    printf("current directory:\n%s\n\n", current_dir);

    /* ask user for new directory */
    printf("enter new directory (or '.' to stay here):\n");
    if (fgets(new_dir, sizeof(new_dir), stdin) == NULL) {
        printf("input error\n");
        printf("=========================================\n");
        return 1;
    }

    /* remove newline at the end if present */
    char *newline = strchr(new_dir, '\n');
    if (newline != NULL) {
        *newline = '\0';
    }

    /* if user entered '.' or empty string, do nothing */
    if (new_dir[0] == '\0' || (new_dir[0] == '.' && new_dir[1] == '\0')) {
        printf("\nno change, staying in the same directory\n");
        printf("=========================================\n");
        return 0;
    }

    /* try to change directory */
    if (change_dir(new_dir) != 0) {
        printf("\ncould not change directory to:\n%s\n", new_dir);
        printf("check if the path exists and you have access\n");
        printf("=========================================\n");
        return 1;
    }

    /* print updated directory */
    if (get_cwd(current_dir, sizeof(current_dir)) == NULL) {
        printf("\nchanged directory, but could not read new path\n");
        printf("=========================================\n");
        return 1;
    }

    printf("\nnew current directory:\n%s\n", current_dir);
    printf("=========================================\n");

    return 0;
}
