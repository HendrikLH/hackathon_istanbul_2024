import { ChevronRightIcon } from "@chakra-ui/icons";
import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  Link,
} from "@chakra-ui/react";

interface BreadCrumbItem {
  label: string;
  href: string;
  isCurrentPage: boolean;
}

interface BreadCrumbProps {
  breadCrumbs: BreadCrumbItem[];
}

export default function BreadCrumbs({ breadCrumbs }: BreadCrumbProps) {
  return (
    <Breadcrumb margin="1em 0 0 0" separator={<ChevronRightIcon color="gray.500" />}>
      {breadCrumbs.map((item, index) => (
        <BreadcrumbItem>
          <BreadcrumbLink as={Link} href={item.href} isCurrentPage={item.isCurrentPage}>
            {item.label}
          </BreadcrumbLink>
        </BreadcrumbItem>
      ))}
    </Breadcrumb>
  );
}
