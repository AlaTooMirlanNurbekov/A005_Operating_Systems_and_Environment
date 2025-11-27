#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
 * OS00 - system welcome info
 *
 * This program prints:
 * - operating system name
 * - cpu architecture
 * - current user name
 * - current date and time
 */

int main(void) {
    const char *os_name;

    /* detect operating system */
#if defined(_WIN32) || defined(_WIN64)
    os_name = "Windows";
#elif defined(__linux__)
    os_name = "Linux";
#elif defined(__APPLE__) && defined(__MACH__)
    os_name = "macOS";
#else
    os_name = "Unknown OS";
#endif

    /* detect architecture */
    int bits = (int)(sizeof(void *) * 8);

    /* get username */
    const char *user = NULL;

#if defined(_WIN32) || defined(_WIN64)
    user = getenv("USERNAME");
#else
    user = getenv("USER");
#endif

    if (user == NULL) {
        user = "Unknown user";
    }

    /* get current time */
    time_t now = time(NULL);
    struct tm *local = localtime(&now);
    char time_str[64];

    if (local != NULL) {
        strftime(time_str, sizeof(time_str), "%Y-%m-%d %H:%M:%S", local);
    } else {
        snprintf(time_str, sizeof(time_str), "Unknown time");
    }

    /* print info */
    printf("=========================================\n");
    printf("               OS00 - info               \n");
    printf("=========================================\n");
    printf("operating system : %s\n", os_name);
    printf("architecture     : %d-bit\n", bits);
    printf("current user     : %s\n", user);
    printf("current date/time: %s\n", time_str);
    printf("=========================================\n");

    return 0;
}
