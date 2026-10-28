#!/bin/bash

LOG_FILE="logs/Anarbek_Ali_system_report.log"

{
    echo "===================================================="
    echo "           DEVOPS SYSTEM MONITORING REPORT          "
    echo "===================================================="
    echo "Student Full Name : Anarbek Ali"
    echo "Student Group     : IT2308"
    echo "Student ID        : 41505"
    echo "Current Date/Time : $(date)"
    echo "Current Username  : $(whoami)"
    echo "OS & Kernel       : $(uname -s -r -v)"
    echo "----------------------------------------------------"
    echo "CPU Information:"
    grep "model name" /proc/cpuinfo | head -n 1
    echo "CPU Cores         : $(nproc)"
    echo "----------------------------------------------------"
    echo "Memory Information:"
    free -h
    echo "----------------------------------------------------"
    echo "Disk Usage:"
    df -h /
    echo "----------------------------------------------------"
    echo "Available Disk Space on Root (/):"
    df -h --output=avail / | tail -n 1 | tr -d ' '
    echo "===================================================="
} | tee "$LOG_FILE"
