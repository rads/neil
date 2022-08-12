(ns babashka.neil.version
  (:require [babashka.neil.meta :as meta]
            [babashka.neil.project :as proj]))

(defn run-root-command [opts]
  (let [deps-edn (proj/read-deps-edn opts)
        project-version (get-in deps-edn [:aliases :neil :project :version]
                                :version-not-set)]
    (prn {:neil meta/version :project project-version})))

(defn print-version []
  (println "neil" meta/version))

(defn neil-version [{:keys [opts]}]
  ; NOTE: The v2 logic will become the new default behavior when the new
  ;       `neil version` is ready for release. This will be removed later on.
  (if (:v2 opts)
    (run-root-command opts)
    (print-version)))
