#include <stdio.h>
#include <stdlib.h>

/*
 * OS01 : environment variable explorer
 *
 * This program:
 * - prints the value of a specific environment variable
 * - shows how the operating system provides configuration
 * - lets you check variables like PATH, HOME, USER, USERNAME
 */

int main(void) {
    char variable_name[64];
    const char *value;

    printf("=========================================\n");
    printf("            OS01 - environment           \n");
    printf("=========================================\n");

    /* ask user for the name of the variable */
    printf("enter environment variable name: ");
    if (scanf("%63s", variable_name) != 1) {
        printf("invalid input\n");
        return 1;
    }

    /* read the variable */
    value = getenv(variable_name);

    if (value == NULL) {
        printf("variable '%s' not found\n", variable_name);
    } else {
        printf("%s = %s\n", variable_name, value);
    }

    printf("=========================================\n");

    return 0;
}
