#!/bin/sh

exec /usr/bin/Starter `hostnamectl --transient | cut -d. -f1`
