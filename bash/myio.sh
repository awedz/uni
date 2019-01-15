#!/bin/bash
nc 199.247.6.180 18000

longcommand | {
    while IFS= read -r line
    do
    whatever "$line"
    lastline="$line"
    done

    # This won't work without the braces.
    echo "The last line was: $lastline"
}