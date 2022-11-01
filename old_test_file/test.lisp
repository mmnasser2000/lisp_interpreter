(list 1 2 3)
(list 1 (list 2 3) 4)

(cons 1 2)
(cons 1 (cons 2 3))

(eval (eval (quote (quote (+ 1 1)))))
(eval (quote (+ 1 1)))

(not 1)
(not nil)

(and 1 2)
(and 2 1)
(and nil 1)
(and 1 nil)

(or 1 1)
(or nil 1)
(or nil nil)


(> 3 1)
(> 3 3)
(> 1 3)

(< 3 1)
(< 3 3)
(< 1 3)

(<= 3 1)
(<= 3 3)
(<= 1 3)

(>= 3 1)
(>= 3 3)
(>= 1 3)

(cond ((> 4 1) 1) ((<= 6  3) 2) ((>= 10 12) 3))
(cond (nil 1) (T 2) (T 3))
(cond ((< 4 1) 1) ((> 1 2) 2) ((>= 5 3) 3))

(setq A 29)
(setq B (+ A 13))
(B)