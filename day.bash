#!/bin/bash

main() {
  local days=( src/day*.clj )
  local prev=${days[-1]//[^0-9]/}
  local next=${1:-$((${prev#0} + 1))}
  next=$(printf '%02d' $next)

  if [[ ! -e src/day$next.clj ]]; then
    sed "s/day$prev/day$next/g" < src/day$prev.clj > src/day$next.clj
  fi

  if [[ ! -e text/day${next}_test.clj ]]; then
    sed "s/day$prev/day$next/g" < test/day${prev}_test.clj > test/day${next}_test.clj
  fi

  touch resources/examples/day$next resources/inputs/day$next

  shopt -s globstar
  vim -O {src,test,resources}/**/day${next}*
}

main "$@"; exit
