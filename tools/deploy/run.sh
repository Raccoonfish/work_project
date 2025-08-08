#!/bin/bash 

ansible-playbook \
    --vault-id=~/.vlt \
    -e ansible_user=eishemgulova \
    -i inventory.yml \
    play.yml -vv