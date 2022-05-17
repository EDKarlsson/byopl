#!/usr/bin/env bash

uniconBin=$1
PATH="${uniconBin}:$PATH"
icnDir=$2

echo "Running: ${uniconBin}/unicon" "${icnDir}"/*
"${uniconBin}"/unicon "${icnDir}"/*

