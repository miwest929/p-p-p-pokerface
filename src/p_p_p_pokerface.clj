(ns p-p-p-pokerface)

(def face-cards {\T 10, \J 11, \Q 12, \K 13, \A 14})
(defn rank [card]
  (let [[r _] card]
  (if (Character/isDigit r) (Integer/valueOf (str r)) (face-cards r))))

(defn suit [card]
  (let [[_ s] card] (str s)))

(defn pair? [hand]
  (let [freq (vals (frequencies (map rank hand)))
        freqCount (fn [c] (count (filter (fn [f] (= c f)) freq)))]
  (and (= 1 (freqCount 2)) (= 3 (freqCount 1)))))

(defn three-of-a-kind? [hand]
  (let [freq (vals (frequencies (map rank hand)))
        freqCount (fn [c] (count (filter (fn [f] (= c f)) freq)))]
  (and (= 1 (freqCount 3)) (= 2 (freqCount 1)))
))

(defn four-of-a-kind? [hand]
  (let [freq (vals (frequencies (map rank hand)))
        freqCount (fn [c] (count (filter (fn [f] (= c f)) freq)))]
  (= 1 (freqCount 4))
))

(defn flush? [hand]
  (let [suits (map suit hand)]
  (= 1 (count (set suits)))
))

(defn full-house? [hand]
  nil)

(defn two-pairs? [hand]
  nil)

(defn straight? [hand]
  (let [ranks (map rank hand)]
  (apply < (sort ranks))
))

(defn straight-flush? [hand]
 (and (straight? hand) (flush? hand))
)

(defn value [hand]
  nil)
