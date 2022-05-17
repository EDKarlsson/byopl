#!/usr/bin/env bash


uniconBin=$1
PATH="${uniconBin}:$PATH"
lexDir=$2
lexFile=$3
outDir=$4

echo "Running: ${uniconBin}/uflex ${lexDir}/${lexFile}.u.flex"
"${uniconBin}"/uflex "${lexDir}/${lexFile}.u.flex"

echo "Moving: ${lexFile}.icn to ${outDir}"
mv  "${lexDir}/${lexFile}.u.flex.icn" "${outDir}/${lexFile}.icn"
