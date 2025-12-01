#!/bin/bash

BRANCHES=("main" "1-local-OK-ci-NOK" "2-local-NOK-ci-OK" "3-test-failures-flaky-vs-non-flaky" "4-test-failures-infra-vs-non-infra" "5-dependency-conflict")
USERS=("John" "Mike" "Laurent")

ORIGINAL_BRANCH=$(git rev-parse --abbrev-ref HEAD)

echo "=================================================="
echo "Starting Local Traffic Simulation"
echo "Branches: ${BRANCHES[*]}"
echo "Users: ${USERS[*]}"
echo "=================================================="

for branch in "${BRANCHES[@]}"; do
    echo ""
    echo "--------------------------------------------------"
    echo "Checking out branch: $branch"
    echo "--------------------------------------------------"

    # Switch to the target branch
    git checkout "$branch"

    for user in "${USERS[@]}"; do
        echo "  > [User: $user] Running build..."

        # Execute Gradle
        # -Duser.name: Simulates the specific user
        ./gradlew build  -Duser.name="$user"

        echo "  > [User: $user] Build complete."
    done
done

echo ""
echo "=================================================="
echo "Simulation complete. Returning to $ORIGINAL_BRANCH"
git checkout "$ORIGINAL_BRANCH"