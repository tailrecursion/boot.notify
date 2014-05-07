# boot.notify

This project contains notification tasks for the [boot][2] Clojure build tool.

### Dependency

Artifacts are published on [Clojars][1]. This version is compatible with
[boot.core][4] version [2.0.0][3] or later.

![latest version][5]

### Tasks

| Task          | Description                                                 |
|---------------|-------------------------------------------------------------|
| hear          | Plays an error sound if an exception is thrown downstream.  |

For more info about a task do `boot [help <task>]`.

### Usage

```clojure
;; build.boot
(set-env!
  :dependencies
  '[[tailrecursion/boot.notify "2.0.0-SNAPSHOT"]])

(require
 '[tailrecursion.boot.task.notify :refer [hear]])
```

```
$ boot hear # Plays a pleasant noise
```

```
$ boot watch hear hoplon # Noises depend on how the hoplon compiler is doing
```

## License

Copyright © 2013 Alan Dipert and Micha Niskin

Distributed under the Eclipse Public License, the same as Clojure.

[1]: https://clojars.org/tailrecursion/boot.notify
[2]: https://github.com/tailrecursion/boot
[3]: https://github.com/tailrecursion/boot.core/tree/2.0.0
[4]: https://github.com/tailrecursion/boot.core
[5]: https://clojars.org/tailrecursion/boot.notify/latest-version.svg?bustcache=1
