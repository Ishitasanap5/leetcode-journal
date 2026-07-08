class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        backtrack(num, target, 0, "", 0, 0);

        return ans;
    }

    private void backtrack(String num, int target,
                           int index,
                           String path,
                           long value,
                           long last) {

        if (index == num.length()) {

            if (value == target)
                ans.add(path);

            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Prevent leading zeros
            if (i != index && num.charAt(index) == '0')
                break;

            String part = num.substring(index, i + 1);

            long cur = Long.parseLong(part);

            if (index == 0) {

                backtrack(num,
                          target,
                          i + 1,
                          part,
                          cur,
                          cur);

            } else {

                // +
                backtrack(num,
                          target,
                          i + 1,
                          path + "+" + part,
                          value + cur,
                          cur);

                // -
                backtrack(num,
                          target,
                          i + 1,
                          path + "-" + part,
                          value - cur,
                          -cur);

                // *
                backtrack(num,
                          target,
                          i + 1,
                          path + "*" + part,
                          value - last + last * cur,
                          last * cur);
            }
        }
    }
}