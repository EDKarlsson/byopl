#!/usr/bin/env bash

uniconBin=$1
PATH="${uniconBin}:$PATH"
icnDir=$2
buildDir="$3/generated/sources/icn"

mkdir -p "${buildDir}"
echo "Running: ${uniconBin}/unicon" "${icnDir}"/*
"${uniconBin}"/unicon -s "${icnDir}"/* -o "${buildDir}/j0"

