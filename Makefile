.PHONY: dev
dev:
	clj -M:repl/conjure

.PHONY: test
test:
	clj -M:test/cognitect
